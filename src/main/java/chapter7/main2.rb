$employees = ["직원A", "직원B", "직원C"]
$basePays = [400, 300, 250]

def sumOfBasePays()
		result = 0
		for basePay in $BasePays
				result += basePay
		end
		puts(result)
end

def calculatePay(name)
		taxRate = getTaxRate()
		pay = calculatePayFor(name, taxRate)
		puts(describeResult(name, pay))
end

def main(operation, args={})
		case(operation)
		when :pay then calculatePay(args[:name])
		when :basePays then sumOfBasePays()
		end
end

main(:basePays)
main(:pay, name:"직원A")