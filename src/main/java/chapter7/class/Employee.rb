class Employee
	attr_reader :name :basePay

	def initialize(name, basePay)
			# 인스턴스 변수명은 '@'로 시작
			@name = name
			@basePay = basePay
	end

  # 시그니처만 정의한 불완전 구현체
	def calculatePay(taxRate)
			raise NotImplementedError
	end

	def monthlyBasePay()
			raise NotImplementedError
	end
end