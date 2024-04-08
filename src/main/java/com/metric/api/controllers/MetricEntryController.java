package com.metric.api.controllers;

import com.metric.api.exceptions.DataException;
import com.metric.api.models.common.ErrorCodes;
import com.metric.api.models.core.MetricEntry;
import com.metric.api.models.interfaces.MetricEntryRequest;
import com.metric.api.services.MetricEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/metrics")
@RestController
public class MetricEntryController {
    @Autowired
    private MetricEntryService metricEntryService;

    @PostMapping(value = "/entries", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MetricEntry> createMetric(@Valid @RequestBody MetricEntryRequest metric, BindingResult result) {
        if (result.hasErrors()) {
            throw new DataException(ErrorCodes.EXC400.toString(), result);
        }

        MetricEntry metricCreated = metricEntryService.createMetricEntry(metric);

        return new ResponseEntity<>(metricCreated, HttpStatus.CREATED);
    }
}
