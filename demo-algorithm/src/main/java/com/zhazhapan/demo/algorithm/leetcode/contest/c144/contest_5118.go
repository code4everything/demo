package c144

func corpFlightBookings(bookings [][]int, n int) []int {
	answer := make([]int, n)
	for _, v := range bookings {
		start := v[0] - 1
		end := v[1]
		for ; start < end; start++ {
			answer[start] += v[2]
		}
	}
	return answer
}
