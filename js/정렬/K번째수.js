function solution(array, commands) {
    let answer = [];
    commands.forEach((command) => {
        let [i,j,k] = command;
        // console.log(i,j,k);
        let arr = array //체이닝 적용
            .slice(i-1,j)
            .sort();
        // console.log(arr);
        answer.push(arr[k-1]);
    })
    return answer;
}

function other_solution(array, commands) {
    return commands.map(command => {
        const [sPosition, ePosition, position] = command
        const newArray = array
            .filter((value, fIndex) => fIndex >= sPosition - 1 && fIndex <= ePosition - 1)
            .sort((a,b) => a - b)    

        return newArray[position - 1]
    })
}


array = [1, 5, 2, 6, 3, 7, 4];
commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]];	

let result = solution(array,commands);
console.log(result);

result = other_solution(array,commands);
console.log(result);