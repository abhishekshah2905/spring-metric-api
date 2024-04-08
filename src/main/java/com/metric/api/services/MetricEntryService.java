package com.metric.api.services;

import com.metric.api.models.core.MetricEntry;
import com.metric.api.models.interfaces.MetricEntryRequest;

public interface MetricEntryService {
    MetricEntry createMetricEntry(MetricEntryRequest metric);
}
