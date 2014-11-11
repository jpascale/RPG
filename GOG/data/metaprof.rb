# Ejercicio de metaprogramming

#Proxy.rb
class Proxy

	def initialize(target)
		@target = target
		@hash = Hash.new(0) #Default value 0
	end

	def method_missing(m, *args, &block)
		@hash[m] += 1
		@target.send(m, *args, &block)
	end

	def __called__?(m)
		@hash.include?(m)
	end

	def __cant__(m)
		@hash[m]
	end

end

#Main.rb
require  'untitled.rb' #TravelCard
#require './Proxy.rb'

card = Proxy.new(TravelCard.new(20))
puts card.balance

card.travel("20141111", "Catedral Linea D", 4.5)
puts card.balance

card.movements.each do |x|
	puts "#{x.date} - #{x.description} - #{x.price}"
end

puts "Charge called?" + card.__called__?(:charge).to_s
puts "Card travel " + card.__cant__(:travel).to_s