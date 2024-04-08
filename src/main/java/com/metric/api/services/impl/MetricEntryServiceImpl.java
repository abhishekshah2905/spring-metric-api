package com.metric.api.services.impl;

import com.metric.api.exceptions.NotFoundException;
import com.metric.api.models.common.ErrorCodes;
import com.metric.api.models.core.Metric;
import com.metric.api.models.core.MetricEntry;
import com.metric.api.models.interfaces.MetricEntryRequest;
import com.metric.api.repositories.MetricEntryRepository;
import com.metric.api.repositories.MetricRepository;
import com.metric.api.services.MetricEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MetricEntryServiceImpl implements MetricEntryService {
    @Autowired
    private MetricEntryRepository metricEntryRepository;

    @Autowired
    private MetricRepository metricRepository;

    @Override
    public MetricEntry createMetricEntry(MetricEntryRequest metricReq) {
        Optional<Metric> metricOptional = this.metricRepository.findById(metricReq.getMetricId());
        if (!metricOptional.isPresent()) {
            throw new NotFoundException(ErrorCodes.EXC404.getValue(), null);
        }
        Metric metric = metricOptional.get();

        MetricEntry entry = new MetricEntry();
        entry.setValue(metricReq.getValue());
        entry.setMetric(metricOptional.get());

        metric.setMetricEntry(entry);
        this.metricRepository.save(metric);

        return entry;
    }
}
