class IsValid {
    public void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        char[] stack = new char[s.length() + 1 / 2];
        int countStack = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (countStack < 0) {
                return false;
            }
            if (c == '(') {
                stack[countStack++] = '(';
                continue;
            }
            if (c == '{') {
                stack[countStack++] = '{';
                continue;
            }
            if (c == '[') {
                stack[countStack++] = '[';
                continue;
            }
            if (c == ')') {
                if (countStack == 0) {
                    return false;
                }
                if (stack[countStack - 1] == '(') {
                    countStack--;
                } else {
                    return false;
                }
            }
            if (c == '}') {
                if (countStack == 0) {
                    return false;
                }
                if (stack[countStack - 1] == '{') {
                    countStack--;
                } else {
                    return false;
                }
            }
            if (c == ']') {
                if (countStack == 0) {
                    return false;
                }
                if (stack[countStack - 1] == '[') {
                    countStack--;
                } else {
                    return false;
                }
            }
        }
        if (countStack == 0) {
            return true;
        } else {
            return false;
        }
    }
}