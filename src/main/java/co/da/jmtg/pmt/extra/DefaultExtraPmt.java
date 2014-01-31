package co.da.jmtg.pmt.extra;

import co.da.jmtg.amort.PmtKey;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;

/**
 * The default implementation of <tt>ExtraPmt</tt>. This object contains the amount of the extra payment, the number of
 * payments to which the extra payment will be applied, and a PmtKey object. The PmtKey object indicates the start date
 * of the extra payment. This start date must match exactly with the date of one of the regular mortgage payments. The
 * PmtKey also indicates the interval of the extra payment. Valid interval values are Onetime, Yearly, Monthly,
 * Biweekly, and Weekly. This object is immutable as long as the implementation of <tt>PmtKey</tt> it uses is immutable.
 * <tt>DefaultPmtKey</tt> is immutable, so if this instance uses an implementation of <tt>DefaultPmtKey</tt>, its thread
 * safety is guaranteed.
 * 
 * @since 1.0
 * @author David Armstrong
 */
class DefaultExtraPmt implements ExtraPmt {

    private final PmtKey pmtKey;
    private final double amount;

    private volatile int hashCode;

    private static final Interner<ExtraPmt> interner = Interners.newStrongInterner();

    /**
     * Creates an object with the specified <tt>PmtKey</tt> instance, count, and amount.
     * 
     * @param pmtKey
     *            The <tt>PmtKey</tt> instance
     * @param count
     *            The count value
     * @param amount
     *            The amount value
     */
    private DefaultExtraPmt(PmtKey pmtKey, double amount) {
        Preconditions.checkNotNull(pmtKey, "pmtKey must not be null.");
        Preconditions.checkArgument(amount > 0.0, "amount must be greater than 0.");

        this.pmtKey = pmtKey;
        this.amount = amount;
    }

    public static ExtraPmt getInstance(PmtKey pmtKey, double amount) {
        return interner.intern(new DefaultExtraPmt(pmtKey, amount));
    }

    @Override
    public PmtKey getPmtKey() {
        return pmtKey;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public ExtraPmt setPmtKey(PmtKey pmtKey) {
        return getInstance(pmtKey, amount);
    }

    @Override
    public ExtraPmt setAmount(double amount) {
        return getInstance(pmtKey, amount);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("pmtKey", pmtKey)
                .add("amount", amount)
                .toString();
    }

    @Override
    public int hashCode() {
        int result = hashCode;

        if (result == 0) {
            result = Objects.hashCode(pmtKey,
                    amount);
            hashCode = result;
        }

        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (!(object instanceof DefaultExtraPmt)) {
            return false;
        }

        DefaultExtraPmt that = (DefaultExtraPmt) object;
        return Objects.equal(this.pmtKey, that.pmtKey)
                && Objects.equal(this.amount, that.amount);
    }

}
