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

package ksch.patientmanagement.opdnumber;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OpdNumberGeneratorTest {

    private static final int NUMERIC_VALUE = 1011;

    @InjectMocks
    private OpdNumberGeneratorImpl opdNumberGenerator;

    @Mock
    private OpdNumberRepository opdNumberRepository;

    private final int currentYearWithTwoDigits = Calendar.getInstance().get(Calendar.YEAR) % 100;

    @Before
    public void setup() {
        when(opdNumberRepository.save(any(NumericValue.class)))
                .thenReturn(new NumericValue(NUMERIC_VALUE));
    }

    @Test
    public void should_prepend_year() {
        String generatedOpdNumber = opdNumberGenerator.generateOpdNumber();

        assertTrue("Generated OPD number '" + generatedOpdNumber + "' doesn't start with current year",
                generatedOpdNumber.startsWith(currentYearWithTwoDigits + "-"));
    }

    @Test
    public void should_contain_patient_index_number() {
        String generatedPatientNumber = opdNumberGenerator.generateOpdNumber();

        assertTrue("Generated patient number '" + generatedPatientNumber +
                        "' doesn't contain the patient index number '" + NUMERIC_VALUE + "'.",
                generatedPatientNumber.contains("-" + NUMERIC_VALUE));
    }
}
