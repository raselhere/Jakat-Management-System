
public interface RulesAndRegulations {
	public final int ageLimit = 18; // >= 18
	public final double balanceLiminit = 450000; // >= 450000
	public static final double zakatPercentage = 0.025; // 0.2

	public abstract double zakatAmountCounter(double amount);
}
