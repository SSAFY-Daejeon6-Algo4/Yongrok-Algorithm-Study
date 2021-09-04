import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        
        String[] uidLog = new String[record.length];
        String[] msgLog = new String[record.length];
        int idx = 0;
        
        for(int i=0;i<record.length;i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            
            String command = st.nextToken();
            String uid = st.nextToken();
            
            if(command.equals("Change")){
                String nickname = st.nextToken();
                user.put(uid, nickname);
            }else if(command.equals("Enter")){
                String nickname = st.nextToken();
                user.put(uid, nickname);
                
                uidLog[idx] = uid;
                msgLog[idx++] = "님이 들어왔습니다.";
            }else if(command.equals("Leave")){
                uidLog[idx] = uid;
                msgLog[idx++] = "님이 나갔습니다.";
            }
        }
        
        String[] answer = new String[idx];
        for(int i=0;i<idx;i++){
            StringBuilder tmp = new StringBuilder();
            
            tmp.append(user.get(uidLog[i])).append(msgLog[i]);
            
            answer[i] = tmp.toString();
        }
        
        return answer;
    }
}