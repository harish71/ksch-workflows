/*
 * Copyright 2019 KS-plus e.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ksch.medicalrecords;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * An item in the medical records of a patient.
 */
public interface MedicalRecordEntry {

    /**
     * @return The technical identifier for this medical record entry.
     */
    UUID getId();

    /**
     * @return The reference to the technical indentifier of the {@link ksch.patientmanagement.visit.Visit}
     * during which this medical record entry was taken.
     */
    UUID getVisitId();

    /**
     * @return The point in time when the medical record entry was taken.
     */
    LocalDateTime getTime();
}
