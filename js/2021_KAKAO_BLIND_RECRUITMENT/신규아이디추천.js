function solution(new_id) {
    let answer = '';

    // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    answer = new_id.toLowerCase();
    // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    let delete_str = []; //제거할 문자 담는 배열
    let allow_str = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','-','_','.'];
    for (const i in answer){
        if(!allow_str.includes(answer[i])){
            delete_str.push(answer[i]);
        }
    }
    for (const del of delete_str){
        answer = answer.replace(del,'')
    }
    // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    delete_str = []; // 삭제할 문자의 index
    for (const i in answer){
        if(i != 0 && answer[i-1] == '.' && answer[i] =='.'){
           delete_str.push(i);
        }
    }

    let prev_index = 0;
    let result = '';
    for (const index of delete_str){
        // console.log(prev_index,index)
        result += answer.substring(prev_index,index);
        // console.log(result)
        prev_index = parseInt(index)+1;
    }
    result += answer.substring(prev_index,answer.length);
    answer = result;

    // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.

    while(answer.slice(0,1) == '.'){
        answer = answer.slice(1,);
    }
    while(answer.slice(-1) == '.'){
        answer = answer.slice(0,-1);
    }
    // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    if(answer == '') answer = 'a'
    
    // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    if(answer.length >= 16){
        answer = answer.slice(0,15)
    }
    while(answer.slice(-1) == '.'){
        answer = answer.slice(0,-1);
    }
    // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    while(answer.length <=2 ){
        answer += answer.slice(-1);
    }
    return answer;
}

// 정규 표현식을 활용한 다른 분의 코드
/* /와 /g가운데에 정규표현식을 넣으세요.
 * g는 global의 약자로, 정규표현식과 일치하는 모든 내용을 찾아오라는 옵션입니다.
 */
function good_solution(new_id) {
    const answer = new_id
        .toLowerCase() // 1 -> 소문자로 변경
        .replace(/ [^\w-_.] /g, '') // 2 -> 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
        // [^] : 해당하지 않는 글자를 찾는다.
        // \w : 영어 알파벳, 숫자, 언더스코어(_)
        .replace(/ \.+ /g, '.') // 3 -> 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        // +는 "하나 혹은 그 이상 연결된"
        .replace(/ ^\. | \.$ /g, '') // 4 -> 마침표(.)가 처음이나 끝에 위치한다면 제거
        // ^ : 줄(Line)의 시작에서 일치
        // $ : 줄(Line)의 끝에서 일치
        .replace(/ ^$ /, 'a') // 5 -> 빈 문자열이라면, "a"를 대입
        .slice(0, 15).replace(/\.$/, ''); // 6 -> 길이가 16자 이상이면,첫 15개의 문자를 제외한 나머지 문자들을 모두 제거 + 마침표(.)가 끝에 위치한다면 마침표(.) 문자를 제거
    const len = answer.length;
    return len > 2 ? answer : answer + answer.charAt(len - 1).repeat(3 - len); //7 -> 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙암
}

new_id = "...!@BaT#*..y.abcdefghijklm"; // "bat.y.abcdefghi"
// new_id = "z-+.^.";// "z--"
// new_id = "=.=";// "aaa"
// new_id = "123_.def";// "123_.def"
// new_id = "abcdefghijklmn.p";// "abcdefghijklmn"

result1 = solution(new_id);
console.log(result1);

result2 = good_solution(new_id);
console.log(result2);