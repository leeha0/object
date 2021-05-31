# 상속 관계를 표현 '자식클래스 < 부모클래스'
class SalariedEmployee < Employee
		def initialize(name, basePay)
				super(name, basePay)
		end

		def calculatePay(taxRate)
				return basePay - (basePay * taxRate)
		end

		def monthlyBasePay()
				return basePay
		end
end