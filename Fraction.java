interface FractionInterface {
    double getDecimalValue();
    void setFraction(int numerator, int denominator);
}

class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;
    private Double cachedValue;       // кэш для вещественного значения

    public Fraction(int numerator, int denominator) {
        setFraction(numerator, denominator);
    }

    public int getNumerator() {
        return numerator; }
    public int getDenominator() {
        return denominator; }

    @Override
    public void setFraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0.");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;

        // При изменении дроби сбрасываем кэш
        this.cachedValue = null;
    }

    @Override
    public double getDecimalValue() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction)) return false;
        Fraction other = (Fraction) obj;
        // Сравниваем дроби по значению (пропорция)
        return this.numerator * other.denominator == this.denominator * other.numerator;
    }
    // для быстрого поиска объектов
    @Override
    public int hashCode() {
        return Integer.hashCode(numerator) * 31 + Integer.hashCode(denominator);
    }
}
