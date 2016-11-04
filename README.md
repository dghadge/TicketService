###  Ticket Service : A neat application to find and reserve hard to get tickets

###  Technical Components
     Backend   : Spring Boot
     Database  : H2 (using file based option to persist data between app re-runs)
     DAO       : Spring JDBCTemplate
     Testing   : JUnit, Mockito, Hamcrest

### Rest API(s)

/seats    : returns number of available seats. 
            Example : curl localhost:8090/seats
/hold     : holds a given number of seats(numSeats) for a particular customer (customerEmail). 
          : returns object containing unique SeatHoldId and seats on hold.
          : Customer has 15 mins to reserve the seats once they are held. After 15 mins, these seats are returned to available status.
            Example : curl -X PUT -d numSeats=2 -d customerEmail="@gmail.com" http://localhost:8090/hold

/reserve  : reserves seats for seatHoldId and customerEmail
            Example : curl -X PUT -d seatHoldId=10 -d customerEmail="nyy@gmail.com" http://localhost:8090/reserve

