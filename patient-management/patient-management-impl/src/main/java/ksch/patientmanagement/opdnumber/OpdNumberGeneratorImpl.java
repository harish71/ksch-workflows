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

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
@RequiredArgsConstructor
class OpdNumberGeneratorImpl implements OpdNumberGenerator {

    private static final int currentYearWithTwoDigits = Calendar.getInstance().get(Calendar.YEAR) % 100;

    private final OpdNumberRepository opdNumberRepository;

    @Override
    public synchronized String generateOpdNumber() {
        NumericValue numericValue = opdNumberRepository.save(new NumericValue());
        return String.format("%s-%s", currentYearWithTwoDigits, numericValue);
    }
}
