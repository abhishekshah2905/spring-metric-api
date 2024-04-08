package com.metric.api.services;

import com.metric.api.models.core.Metric;
import com.metric.api.models.interfaces.Statistics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MetricService {
    Metric createMetric(Metric metric);

    Page<Metric> getMetricNames(Pageable pageable);

    Statistics getSummaryStatistics(long metricId, List<String> statisticNames);
}
