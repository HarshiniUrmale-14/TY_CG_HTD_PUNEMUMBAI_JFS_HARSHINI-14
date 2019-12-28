export class Book {
    constructor(
        public hotelId: number,
        public amount: number,
        public bookingId: number,
        public checkinDate: Date,
        public checkoutDate: Date,
        public modeOfPayment: string,
        public paymentStatus: string,
        public roomId: number,
        public userId: number,
        public hotelName: string,
        public userName: string,
        public days: number
    ) { }
}
