function solution(id_list, report, k) {
    report = [...new Set(report)]; // 중복 처리
    let answer = new Array(id_list.length); // 정답 저장 변수
    let receiver_count = new Array(id_list.length);
    let sender_count = new Array(id_list.length);
    for (let i = 0; i < id_list.length; i++) {
        answer[i] = 0;
        receiver_count[i] = 0;
        sender_count[i] = '';
    }
    for (const r of report){
        x = r.split(" "); // 신고 내용 [전송자, 수신자]
        let sender_num;
        let receiver_num;

        for (let i in id_list){ // 전송자, 수신자 찾기
            if(id_list[i] == x[1]){
                receiver_count[i]++; // 수신 횟수 체크
                sender_num = i;
            }
            if(id_list[i] == x[0]){
                receiver_num = i;   
            }
        }
        sender_count[sender_num] += (receiver_num+" "); 
    }
    // console.log(sender_count);
    for(let x in sender_count){
        if(receiver_count[x] < k) continue;
        if(sender_count[x] == '') continue;
        
        y = sender_count[x].split(" ");
        for(let z=0; z<(y.length-1); z++){
            let num = y[z];
            answer[num] ++;
            // console.log('z: ',z,' num : ',num, ' answer[num] : ',answer[num]);
        }
    }
    return answer;
}

let id_list = ["muzi", "frodo", "apeach", "neo"];
let report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi","muzi apeach","apeach muzi","apeach neo","frodo apeach"];

// let id_list = ["con", "ryan"];
// let report = ["ryan con", "ryan con", "ryan con", "ryan con"];

let k = 1;

let result = solution(id_list,report,k);
console.log(result);
