package co.da.jmtg.amort;

import java.util.Map;

import org.joda.time.LocalDate;

import co.da.jmtg.pmt.PmtCalculator;
import co.da.jmtg.pmt.extra.ExtraPmt;

public class FixedAmortizationCalculators {

    private FixedAmortizationCalculators() {
    }

    /**
     * Creates a DefaultFixedAmortizationCalculator with no extra payments
     * 
     * @param pmtCalculator
     *            The mortgage data, including payment amounts, for the mortgage this FixedAmortizationCalculator will
     *            represent
     * @param pmtKey
     *            The mortgage start date, and interval between payments for this mortgage
     * 
     * @return DefaultFixedAmortizationCalculator
     * 
     * @throws NullPointerException
     *             if pmtCalculator or pmtKey is null.
     * 
     * @throws IllegalArgumentException
     *             if PmtPeriod in PmtCalculator is not BIWEEKLY, RAPID_BIWEEKLY, MONTHLY, WEEKLY, or RAPID_WEEKLY.
     */
    public static FixedAmortizationCalculator getDefaultFixedAmortizationCalculator(PmtCalculator pmtCalculator,
            PmtKey pmtKey) {
        return DefaultFixedAmortizationCalculator.getInstance(pmtCalculator, pmtKey);
    }

    /**
     * Creates a DefaultFixedAmortizationCalculator with extra payments
     * 
     * @param pmtCalculator
     *            The mortgage data, including payment amounts, for the mortgage this FixedAmortizationCalculator will
     *            represent
     * @param pmtKey
     *            The mortgage start date, and interval between payments for this mortgage
     * @param extraPmts
     *            extra payments for this mortgage, represented by an ExtraPmt object
     * 
     * @return DefaultFixedAmortizationCalculator
     * 
     * @throws NullPointerException
     *             if pmtCalculator, pmtKey, or extraPmts is null.
     * 
     * @throws IllegalArgumentException
     *             if PmtPeriod in PmtCalculator is not BIWEEKLY, RAPID_BIWEEKLY, MONTHLY, WEEKLY, or RAPID_WEEKLY.
     * 
     * @throws IllegalArgumentException
     *             if extraPmts contains dates that are not valid payment dates for the mortgage this object represents.
     */
    public static FixedAmortizationCalculator getDefaultFixedAmortizationCalculator(PmtCalculator pmtCalculator,
            PmtKey pmtKey, ExtraPmt extraPmts) {
        return DefaultFixedAmortizationCalculator.getInstance(pmtCalculator, pmtKey, extraPmts);
    }

    /**
     * Creates a DefaultFixedAmortizationCalculator with extra payments
     * 
     * @param pmtCalculator
     *            The mortgage data, including payment amounts, for the mortgage this FixedAmortizationCalculator will
     *            represent
     * @param pmtKey
     *            The mortgage start date, and interval between payments for this mortgage
     * @param extraPmts
     *            extra payments for this mortgage, represented by an Iteration of ExtraPmt objects
     * 
     * @return DefaultFixedAmortizationCalculator
     * 
     * @throws NullPointerException
     *             if pmtCalculator, pmtKey, or extraPmts is null.
     * 
     * @throws IllegalArgumentException
     *             if PmtPeriod in PmtCalculator is not BIWEEKLY, RAPID_BIWEEKLY, MONTHLY, WEEKLY, or RAPID_WEEKLY.
     * 
     * @throws IllegalArgumentException
     *             if extraPmts contains dates that are not valid payment dates for the mortgage this object represents.
     */
    public static FixedAmortizationCalculator getDefaultFixedAmortizationCalculator(PmtCalculator pmtCalculator,
            PmtKey pmtKey, Iterable<ExtraPmt> extraPmts) {
        return DefaultFixedAmortizationCalculator.getInstance(pmtCalculator, pmtKey, extraPmts);
    }

    /**
     * Creates a DefaultFixedAmortizationCalculator with extra payments
     * 
     * @param pmtCalculator
     *            The mortgage data, including payment amounts, for the mortgage this FixedAmortizationCalculator will
     *            represent
     * @param pmtKey
     *            The mortgage start date, and interval between payments for this mortgage
     * @param extraPmts
     *            extra payments for this mortgage, represented by an Map<LocalDate, Double> object
     * @return DefaultFixedAmortizationCalculator
     * 
     * @throws NullPointerException
     *             if pmtCalculator, pmtKey, or extraPmts is null.
     * 
     * @throws IllegalArgumentException
     *             if PmtPeriod in PmtCalculator is not BIWEEKLY, RAPID_BIWEEKLY, MONTHLY, WEEKLY, or RAPID_WEEKLY.
     * 
     * @throws IllegalArgumentException
     *             if extraPmts contains dates that are not valid payment dates for the mortgage this object represents.
     */
    public static FixedAmortizationCalculator getDefaultFixedAmortizationCalculator(PmtCalculator pmtCalculator,
            PmtKey pmtKey, Map<LocalDate, Double> extraPmts) {
        return DefaultFixedAmortizationCalculator.getInstance(pmtCalculator, pmtKey, extraPmts);
    }
}
