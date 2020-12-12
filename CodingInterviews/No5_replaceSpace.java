/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-11 18:07:17
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-11 18:45:44
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

public class No5_replaceSpace {
    public String replaceSpace(String s) {

        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) == ' ') {
                sb.append("   ");// 先得到最后的长度
            }    
        }

        int sPos = s.length() - 1;
        int sbPos = sb.length() - 1;

        // %20
        while(sPos-- >= 0) {
            if(s.charAt(sPos) == ' ') {
                sb.setCharAt(sbPos--, '0');
                sb.setCharAt(sbPos--, '2');
                sb.setCharAt(sbPos--, '%');
            } else {
                sbPos--;
            }
        }

        return sb.toString();
    }
}
