package com.metric.api.controllers;

import com.metric.api.exceptions.DataException;
import com.metric.api.models.common.ErrorCodes;
import com.metric.api.models.core.Metric;
import com.metric.api.models.interfaces.MetricRequest;
import com.metric.api.models.interfaces.Statistics;
import com.metric.api.services.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/metrics")
@RestController
public class MetricController {
    @Autowired
    private MetricService metricService;

    @PostMapping(value ="/names", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createMetricName(@Valid @RequestBody MetricRequest metricRequest, BindingResult result) {
        if (result.hasErrors()) {
            throw new DataException(ErrorCodes.EXC400.toString(), result);
        }

        Metric metric = new Metric();
        metric.setName(metricRequest.getMetricName());
        metricService.createMetric(metric);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/names", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<Metric>> getMetricNames(Pageable pageable) {
        Page<Metric> metricPage = this.metricService.getMetricNames(pageable);
        return new ResponseEntity<>(metricPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/statistics", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Statistics> getStatistics(@PathVariable("id") long metricId, @RequestParam(value = "statistics", required = false) List<String> statistics) {
        Statistics statisticsValues = this.metricService.getSummaryStatistics(metricId, statistics);
        return new ResponseEntity<>(statisticsValues, HttpStatus.OK);
    }
}
