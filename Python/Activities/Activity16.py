class Car:
    def __init__ (self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.make = make
        self.model = model
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " is moving")
    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped")

car1 = Car("Toyota", "Corolla", "2015", "Manual", "White")
car2 = Car("Maruti", "800", "2013", "Manual", "Red")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "Black")
car4 = Car(input("Enter the details of the properties: "))
car2.accelerate()
car1.stop()
car4.accelerate()