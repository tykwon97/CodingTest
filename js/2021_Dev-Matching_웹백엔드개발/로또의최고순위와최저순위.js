function solution(lottos, win_nums) {
    lottos = lottos.sort((a, b) => a - b);
    win_nums = win_nums.sort((a, b) => a - b);

    let correct_count = 0;
    let zero_count = 0;

    for (const x of lottos){
        if(x == 0){
            zero_count ++;
            continue;
        }
        for(const y of win_nums){
            if(x == y) correct_count++;
        }
    }
    // console.log(zero_count);
    // console.log(correct_count);

    a = 7-correct_count-zero_count;
    b = 7-correct_count;
    if(a>6) a=6;
    if(b>6) b=6;
    let answer = [a,b];
    return answer;
}

function good_solution(lottos, win_nums) {
    const rank = [6, 6, 5, 4, 3, 2, 1];

    let minCount = lottos.filter(v => win_nums.includes(v)).length;
    let zeroCount = lottos.filter(v => !v).length; //!0은 true

    const maxCount = minCount + zeroCount;

    return [rank[maxCount], rank[minCount]];
}


let lottos = [44, 1, 0, 0, 31, 25];
let win_nums = [31, 10, 45, 1, 6, 19];

result1 = solution(lottos, win_nums);
console.log(result1);

result2 = good_solution(lottos, win_nums);
console.log(result2);