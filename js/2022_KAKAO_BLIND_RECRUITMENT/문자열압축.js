function solution(s) {
    let answer = 1001;
    let count;
    let check; //자리수가 바뀌는 경우

    let prev_prev_str = ''
    let prev_str = '';

    if(s.length == 0) return 0;
    if(s.length == 1) return 1;

    for(let i=1; i<s.length; i++){ //1부터 문자열길이까지
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

// s = "aabbaccc"; //7
// s = "ababcdcdababcdcd"; //9
// s = "abcabcdede"; //8
// s = "abcabcabcabcdededededede"; //14
// s = "xababcdcdababcdcd"; //17

 s = "a";

let result = solution(s);
console.log(result);