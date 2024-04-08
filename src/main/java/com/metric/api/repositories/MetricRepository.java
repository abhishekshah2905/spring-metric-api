package com.metric.api.repositories;

import com.metric.api.models.core.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricRepository extends JpaRepository<Metric, Long> {
    Metric findByName(String name);
}
