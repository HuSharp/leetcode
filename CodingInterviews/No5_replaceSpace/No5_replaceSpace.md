#### [剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)



先计算出最后每个空格需要添加 2 个 " " 的最终长度

从后往前，采用一个 `StringBuffer` 进行保存字符串并更改。

- 遇到 " " 时，改为 "%20"
- 遇到非 " " 时，复制到当前对应位置

```java
    public String replaceSpace(String s) {

        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) == ' ') {
                sb.append("  ");// 先得到最后的长度
            }    
        }

        int sPos = s.length() - 1;
        int sbPos = sb.length() - 1;

        // %20
        while(sPos != -1) {
            char c = s.charAt(sPos--);
            if(c == ' ') {
                sb.setCharAt(sbPos--, '0');
                sb.setCharAt(sbPos--, '2');
                sb.setCharAt(sbPos--, '%');
            } else {
                sb.setCharAt(sbPos--, c);
            }
        }

        return sb.toString();
    }
```

