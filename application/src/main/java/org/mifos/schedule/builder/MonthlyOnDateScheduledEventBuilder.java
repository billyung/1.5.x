/*
 * Copyright (c) 2005-2010 Grameen Foundation USA
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * See also http://www.apache.org/licenses/LICENSE-2.0.html for an
 * explanation of the license and how it is applied.
 */

package org.mifos.schedule.builder;

import org.mifos.application.meeting.util.helpers.RankType;
import org.mifos.application.meeting.util.helpers.WeekDay;
import org.mifos.schedule.ScheduledEvent;
import org.mifos.schedule.internal.MonthlyOnDateScheduledEvent;

/**
 *
 */
public class MonthlyOnDateScheduledEventBuilder extends ScheduledEventBuilder {

    private Integer dayOfMonth;

    MonthlyOnDateScheduledEventBuilder(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Override
    public ScheduledEventBuilder monthlyOnWeekAndWeekday(RankType weekOfMonth, WeekDay dayOfWeek) {
        assert false : "Type of monthly schedule has already been set.";
        return null;
    }

    @Override
    public ScheduledEventBuilder monthlyOnDate (Integer dayOfMonth) {
        assert dayOfMonth != null;
        assert (dayOfMonth >= 1) && (dayOfMonth <= 31);
        return new MonthlyOnDateScheduledEventBuilder(dayOfMonth);
    }


    @Override
    public ScheduledEvent build() {
        if ( (dayOfMonth < 1) || (dayOfMonth > 31) ) {
            throw new IllegalArgumentException("Scheduled day of month must be between 1 and 31");
        }
        return new MonthlyOnDateScheduledEvent(every, dayOfMonth);
    }
}
