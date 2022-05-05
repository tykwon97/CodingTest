function solution(participant, completion) {
    // 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
    // 위 문장을 안 읽음...
    let answer = [...participant]; //good_solution에서 같은 participant를 사용

    for(const user of completion){
        let index = answer.indexOf(user)
        if(index == -1) {
            answer[0] = user;
            break;
        }
        // splice는 시간복잡도를 많이 사용
        answer.splice(index,1);
    }
    return answer[0];
}

function good_solution(participant, completion) {
    let p = [...participant];
    let c = [...completion];
    
    p.sort();
    c.sort();
    for(const index in p){
        if(p[index] != c[index]){
            return p[index];
        }   
    }
    return '';
}

function hash1_solution(participant, completion) {
    let hashed = {} //객체 - key와 value 사용
    participant.forEach(entry => {
        hashed[entry] = hashed[entry] ? hashed[entry] + 1 : 1        
    })
    completion.forEach(entry => {
        hashed[entry] = hashed[entry] - 1
    })

    for (let key in hashed) {
        if (hashed[key] >= 1) return key
    }
}

function hash2_solution(participants, completions) {
    const myMap = new Map(); // Map을 활용해서 key, value 사용

    for ( const participant of participants){
        if(!myMap.get(participant)){
            myMap.set(participant, 1);
        }else{
            myMap.set(participant, myMap.get(participant)+1);
        }
    }

    for(const completion of completions){
        if(myMap.get(completion)){
            myMap.set(completion, myMap.get(completion)-1);
        }
    }
    
    for(const participant of participants){
        if(myMap.get(participant) >= 1 ){
            answer = participant;
        }
    }

    return answer;
}

a = ["leo", "kiki", "eden"];
b = ["eden", "kiki"]; // "leo"

// a = ["marina", "josipa", "nikola", "vinko", "filipa"];
// b =	["josipa", "filipa", "marina", "nikola"] // "vinko"

a = ["mislav", "stanko", "mislav", "ana"];
b =	["stanko", "ana", "mislav"]	// "mislav"

let result;

result = solution(a,b);
console.log(result);

result = good_solution(a,b);
console.log(result);

// 해시를 사용한 풀이
result = hash1_solution(a,b);
console.log(result);

result = hash2_solution(a,b);
console.log(result);