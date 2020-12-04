require 'functions'

local function isValid(passport)
    for _, key in ipairs({'byr', 'iyr', 'eyr', 'hgt', 'hcl', 'ecl', 'pid'}) do
        if passport[key] ~= null then
        else
            return false
        end
    end

    return true
end

print(countValidPassports(isValid))
