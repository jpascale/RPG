
#movement.rb
class Movement
	attr_reader :date, :description, :price

	def initialize(date, description, price)
		@date = date
		@description = description
		@price = price
	end

end

#TravelCard.rb
class Fecha
	def self.validate(date)
	end
end

class TravelCard

	@@overdraft = 10

	attr_reader :balance

	def initialize(initial=0)
		@balance = initial;
		@movements = []
	end

	def charge(amount)
		if amount <= 0
			raise "Amount must be positive."
		end
		@balance += amount
	end

	def travel(date, description, price)
		Fecha.validate(date)

		if @balance - price < @@overdraft
			raise "No enought founds"
		end
		@balance -= price
		@movements.push(Movement.new(date, description, price))

	end

	def movements
		ret = []
		@movements.each { | x | ret.push(x)}
	end

	def self.overdraft =(overdraft)
		@@overdraft = overdraft # Class variable
	end

end	

class RetiredCard < TravelCard
	DISCOUNT = 0.8 # Constant

	def travel(date, description, price)
		super(date, description, price * DISCOUNT)
	end
end

class StudentCard < TravelCard

	DISCOUNT = 0.2
	DISCOUNT_TRAVELS = 2

	def travel (date, description, price)
		cantTravels = @movements.select { | x | x.date == date}.size #select devuelve objetos que cumplan con la condicion

		if cantTravels < DISCOUNT_TRAVELS
			super(date, description, price * DISCOUNT)
		else
			super(date, description, price)
		end
	end
end

#Main.#!/usr/bin/env ruby -wKU
card = StudentCard.new(20)

puts card.balance
card.travel("20141020", "Catedral", 4.5)