# 직원 추상 데이터 타입
# 캡슐화할 데이터를 결정 - 이름, 기본급, 아르바이트 직원 여부, 작업시간
Employee = Struct.new(:name, :basePay, :hourly, :timeCard) do

    # 시그니처가 더 간단해졌다.
    def calculatePay(taxRate)
				if (hourly) then
						return calculateHourlyPay(taxRate)
				end
				return calculateSalariedPay(taxRate)
		end

		private
        def calculateHourlyPay(taxRate)
            return (basePay * timeCard) - (basePay * timeCard) * taxRate
        end

        def calculateSalariedPay(taxRate)
            return basePay - (basePay * taxRate)
        end

		# 개별 직원의 기봅급 계산
		def monthlyBasePay()
				if (hourly) then return 0 end
				return basePay
		end
End