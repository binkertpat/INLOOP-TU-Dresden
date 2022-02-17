public class Kingdom {

	public static void main(String[] args) {

		taxespaper(new King(), 2500);
        taxespaper(new Noble(), 220);
        taxespaper(new Peasant(), 2500);
        taxespaper(new Serf(), 2500);
	}

	static void taxespaper(Inhabitant villager,
	                           int income) {
        villager.setIncome(income);
        System.out.println(villager.getClass().getName() +
           ": Einkommen " + income +
           ", zu versteuerndes Einkommen " +
           villager.taxableIncome() +
           ", Steuer " + villager.tax());
    }
}
