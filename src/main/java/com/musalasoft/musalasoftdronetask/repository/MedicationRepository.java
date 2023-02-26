package com.musalasoft.musalasoftdronetask.repository;

import com.musalasoft.musalasoftdronetask.model.Medication;
import org.springframework.data.repository.CrudRepository;

/**
 * Medication Repository.
 */
public interface MedicationRepository extends CrudRepository<Medication, Long> {
}
