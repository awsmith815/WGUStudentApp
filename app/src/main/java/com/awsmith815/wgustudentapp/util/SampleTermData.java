package com.awsmith815.wgustudentapp.util;

import com.awsmith815.wgustudentapp.model.Term;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SampleTermData {

    private static final String SAMPLE_TERM_1 = "Spring";
    private static final String SAMPLE_TERM_2 = "Summer";
    private static final String SAMPLE_TERM_3 = "Fall";


    private static Date getDate(int diff){
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MONTH, diff);
        return cal.getTime();
    }

    public static List<Term> getTerms() {
        List<Term> terms = new ArrayList<>();
        terms.add(new Term(SAMPLE_TERM_1, getDate(0), getDate(1)));
        terms.add(new Term(SAMPLE_TERM_2, getDate(3), getDate(4)));
        terms.add(new Term(SAMPLE_TERM_3, getDate(6), getDate(7)));
        return terms;
    }


}