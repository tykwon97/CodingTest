function solution(s) {
    let answer = 1001;
    let count;
    let check; //자리수가 바뀌는 경우

    let prev_prev_str = ''
    let prev_str = '';

    if(s.length == 0) return 0;
    if(s.length == 1) return 1;

    for(let i=1; i<s.length/2+1; i++){ //1부터 절반까지만 체크하면됨
        count = 0;
        check = 1; 
        for(let j=0; j<s.length; j = j+i){
            let str = s.substr(j,i);
            
            // console.log('i : ',i,' j : ',j,' str : ',str, ' check : ',check)
            // console.log(prev_prev_str,prev_str)

            if(prev_str == str){
                check += 1;
                if(prev_prev_str != prev_str){
                    count += 1;
                    
                }else{
                    let check_num = check;
                    while(check_num >10){
                        check_num = check_num/10;
                    }                 
                    if(check_num%10 == 0){
                        count += 1;
                    }
                }
                
            }else{
                check = 1;
                if(str.length < i){
                    // console.log('str.length : ',str.length, ' i : ',i)
                    count += str.length;
                }else{
                    count += i
                }
            }
            
            prev_prev_str = prev_str;
            prev_str = str;
            // console.log('count : ',count)
        }
        if(answer > count){
            answer = count;
        }
        // console.log(count,'-----------------------------------------');
    }
    return answer;
}

// 다른 사람 코드 리뷰(속도는 내가 만든 코드가 더 빠르다)
const good_solution = s => {
    const range = [...Array(s.length)].map((_, i) => i + 1); // s의 길이와 같은 index에 1을 더한 원소를 갖는 배열 생성
    // console.log(range)
    // console.log(s.length)
    return Math.min(...range.map(i => compress(s, i).length)); // 압축한 글자의 길이를 구해서 최소값을 구한다.
    // i 에는 1부터 s.length까지 들어감
};
  
const compress = (s, n) => {
    const make = ([a, l, c]) => `${a}${c > 1 ? c : ''}${l}`;
    // a는 압축한 결과, l은 내가 짠 코드에서 tempStr, c는 count
    let x = make(
        chunk(s, n).reduce( // 조각 낸 배열이 reduce된다. reduce(누적값, 현재값) 
            ( [a, l, c], e) => 
              // [a, l, c]에 해당
              e === l ? [a, l, c + 1] : [ make([a, l, c]) , e, 1 ] , // [a는 make([a,l,c], l은 e, c = 1 ]
              // e에 해당
              ['', '', 0]   
          )
    );
    // console.log(x)
    return x;
};
  
// 문자열을 i를 기준으로 조각 내는 함수
const chunk = (s, n) =>
    s.length <= n ? [s] : [s.slice(0, n), ...chunk(s.slice(n), n)];

// s = "aabbaccc"; //7
// s = "ababcdcdababcdcd"; //9
// s = "abcabcdede"; //8
// s = "abcabcabcabcdededededede"; //14
// s = "xababcdcdababcdcd"; //17

 s = "aaaaabcd";

let result1 = solution(s);
console.log(result1);

let result2 = good_solution(s);
console.log(result2);