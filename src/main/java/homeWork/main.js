function calculator(string) {
    /*проверяем аргумент данных*/
    const {firstNumber, secondNumber, symbol, mathSystem} = testOperation(string)

    /* получаем нужный калькулятор*/
    const arabicCalculator = calculateArabic[symbol]
    // если система арабская, то считаем сразу, и возвращаем результат
    if (mathSystem === "arabic") {
        checkArabicRange(firstNumber, secondNumber) // проверяем диапазон
        return arabicCalculator(firstNumber, secondNumber).toString()
    }

    /*если система римская, то считаем конвертируем числа в арабские*/
    const {firstConvertNumber, secondConvertNumber} = convertRomanToArabic(firstNumber, secondNumber)
    checkArabicRange(firstConvertNumber, secondConvertNumber)// проверяем диапазон
    const arabicNum = arabicCalculator(firstConvertNumber, secondConvertNumber)
    /*конвертируем обратно, и возвращаем результат*/
    return arabicToRoman(arabicNum)
}

function convertRomanToArabic(firstNumber, secondNumber) {
    const firstConvertNumber = romanToArabic(firstNumber)
    const secondConvertNumber = romanToArabic(secondNumber)
    return {firstConvertNumber, secondConvertNumber}
}

function testOperation(operation) {
    /*если ничего не ввели и это не строка, выбрасываем ошибку*/
    if (!operation || typeof operation !== "string") {
        throw new Error("Строка не является математической операцией")
    }

    /*удаляем пробелы по бокам, .split(" ") делаем из строки массив символов, делим по пробелу*/
    const operationNumber = operation.trim().split(" ")

    /*проверяем длину массива (кол-во символов), если не равно 3, выбрасываем ошибку*/
    if (operationNumber.length !== 3){
        throw new Error("Формат не удовлетворяет заданию")
    }

    /* проверяем оператор, если нет его массиве операторов, выбрасываем ошибку*/
    const symbol = operationNumber[1]
    if (!arithOperatorsArr.includes(symbol)){
        throw new Error("Формат оператора не удовлетворяет заданию")
    }

    const firstNumber = operationNumber[0]
    const secondNumber = operationNumber[2]
    /*проверяем, чтобы оба числа были из одной системы исчисление*/
    const mathSystem = checkMathSystemDigits(firstNumber, secondNumber)

    /*возвращаем объект из чисел, арифм оператора и системы исчисления*/
    return {firstNumber, secondNumber, symbol, mathSystem}
}

function checkMathSystemDigits(firstDigit, secondDigit) {
    // проходимся по массиву из двух чисел с помощью .reduce() и проверяем каждое число и возвращаем для него систему исчисления
    const checkArr = [firstDigit, secondDigit].reduce((acc, digit) => {
        const res = checkRoman(digit) || checkArabic(digit)
        if (!res) {
            throw new Error("Строка не является математической операцией")
        }

        return [...acc, checkRoman(digit) || checkArabic(digit)]
    }, [])

    // если система исчисление неодинаковая, пробрасываем ошибку
    if (checkArr[0] !== checkArr[1]) {
        throw new Error("Строка не является математической операцией")
    }

    // возвращаем систему исчисления
    return checkArr[0]
}

function checkArabicRange(firstNumber, secondNumber) {
    const validRange = firstNumber > 0 && firstNumber <= 10 && secondNumber > 0 && secondNumber <= 10
    if(!validRange) {
        throw new Error("Операнды должны лежать в диапазоне от 1 до 10 включительно, без ноля.")
    }
}


const arithOperatorsArr = ["+", "-", "/", "*"]
const romanNumber = {
    Z: 2000,
    M: 1000,
    CM: 900,
    D: 500,
    CD: 400,
    C: 100,
    XC: 90,
    L: 50,
    XL: 40,
    X: 10,
    IX: 9,
    V: 5,
    IV: 4,
    I: 1
};
const calculateArabic = {
    '+': (firstDigit, secondDigit) => Number(firstDigit) + Number(secondDigit),
    '-': (firstDigit, secondDigit) => Number(firstDigit) - Number(secondDigit),
    '*': (firstDigit, secondDigit) => Number(firstDigit) * Number(secondDigit),
    '/': (firstDigit, secondDigit) => Math.floor(Number(firstDigit) / Number(secondDigit))
}

/*Функции для определения системы исчисления*/
function checkRoman(num) {
    if (/^[IVXLCDMZ]+$/i.test(num)) {
        return "roman"
    }
    return false
}

function checkArabic(num) {
    if (/^\-?\d+$/.test(num)) {
        return "arabic"
    }
    return false
}

function romanToArabic(num) {
    let result = 0
    let prev = 0

    //проходимся по всем символам строки
    for (i = num.length - 1; i >= 0; i--) {
        //находим эквивалент арабской цифры в римской системе
        const current = romanNumber[num[i]]
        //если текущий символ в арабской системе меньше предыдущего символа в арабской системе, то мы из результата вычитаем текущий символ
        if (current < prev) {
            result -= current
        } else {
            // то мы из к результату прибавляем текущий символ в арабской системе
            result += current
        }
        //в конце итерации присваиваем текущий символ к предыдущему
        prev = current
    }

    return result
}


function arabicToRoman(num) {
    let roman = ""

    //превращаем объект римских цифр в массив его ключей и проходимся по ключам
    Object.keys(romanNumber).forEach((key) => {
        //пока арабская цифра больше или равна значению соответствующего ключа в объект римских цифр, добавляем текущий ключ к roman
        while (num >= romanNumber[key]) {
            roman += key;
            //и вычитаем из арабского числа римскую цифру с текущим ключом
            num -= romanNumber[key]
        }
    })

    return roman
}
