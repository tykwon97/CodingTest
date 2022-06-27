function solution(record){
    let answer = [];

    let user = new Map();
    
    for(const message of record){
        let m = message.split(" ");
        // console.log(m);
        if(m[0] == 'Enter'){
            user.set(m[1],m[2])
        }else if(m[0] == 'Change'){
            user.set(m[1],m[2])
        }
    }

    for(const message of record){
        let m = message.split(" ");
        if(m[0] == 'Enter'){
            answer.push(user.get(m[1])+'님이 들어왔습니다.');
        }else if(m[0] == 'Leave'){
            answer.push(user.get(m[1])+'님이 나갔습니다.');
        }else if(m[0] == 'Change'){
            //answer.push(user.get(m[1])+'님이 들어왔습니다.');
        }else{
            console.log('error');
        }
    }
    // console.log(user)
    return answer;
}

function good_solution(record) {
    const userInfo = {}; //객체를 잘 활용함
    const action = [];
    const stateMapping = {  //메시지를 객체에 저장
        'Enter': '님이 들어왔습니다.',
        'Leave': '님이 나갔습니다.'
    }

    record.forEach((v) => {
        const [state, id, nick] = v.split(' '); //한번에 여러 변수 저장 가능!!

        if(state !== "Change") {
            action.push([state, id]);
        }

        if(nick) { //leave는 nick이 없음
            //객체에 id와 nickname 저장
            userInfo[id] = nick;
        }
    })

    // map을 활용해서 깔끔하게 정리한 것 같다.
    return action.map(([state, uid]) => {
        return `${userInfo[uid]}${stateMapping[state]}`;    
    })
}

record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"];
//["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

result1 = solution(record);
console.log(result1)

result2 = good_solution(record);
console.log(result2)