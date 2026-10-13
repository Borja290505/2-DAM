void main(){
  final numbers = [1,2,3,4,5,5,6,7,7,8,9,9];

  print(numbers);
  print('${numbers.length}');
  print('${numbers[0]}');
  print('${numbers.first}');
  //print('${numbers.reversed}');

  final reversedNumbers = numbers.reversed;
  print('${reversedNumbers.toList()}');
  print('${reversedNumbers.toSet()}');

  final numberMasQue5 = numbers.where((int num){
    return num > 5;
  });
  print(numberMasQue5.toSet());
}