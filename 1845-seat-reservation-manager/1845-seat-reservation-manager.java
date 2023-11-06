class SeatManager {
    // Marker to point to unreserved seats.
    int marker;

    // Sorted set to store all unreserved seats.
    TreeSet<Integer> availableSeats;

    public SeatManager(int n) {
        // Set marker to the first unreserved seat.
        marker = 1;
        // Initialize the sorted set.
        availableSeats = new TreeSet<>();
    }

    public int reserve() {
        // If the sorted set has any element in it, then,
        // get the smallest-numbered unreserved seat from it.
        if (!availableSeats.isEmpty()) {
            int seatNumber = availableSeats.first();
            availableSeats.remove(seatNumber);
            return seatNumber;
        }

        // Otherwise, the marker points to the smallest-numbered seat.
        int seatNumber = marker;
        marker++;
        return seatNumber;
    }

    public void unreserve(int seatNumber) {
        // Push the unreserved seat in the sorted set.
        availableSeats.add(seatNumber);
    }
}