package model;

public class Route {

    private String from;
    private String to;
    private Double distance;

    public Route() {
    }

    public Route(String from, String to, Double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        validate();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Double getDistance() {
        return distance;
    }

    private void validate() {
        if (to == null || to.isEmpty()) {
            throw new RuntimeException("destination cannot be null or empty");
        }
        if (from == null || from.isEmpty()) {
            throw new RuntimeException("starting point cannot be null or empty");
        }
        if (distance <= 0) {
            throw new RuntimeException("distance must be bigger than zero km");
        }
    }

    public static Route puneToMumbai = new Route("PUNE", "MUMBAI", 200.0);
    public static Route puneToBangalore = new Route("PUNE", "BANGALORE", 1000.0);
    public static Route mumbaiToDelhi = new Route("MUMBAI", "DELHI", 2050.0);
    public static Route mumbaiToChennai = new Route("MUMBAI", "CHENNAI", 1234.5);
}
