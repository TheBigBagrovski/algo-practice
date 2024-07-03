package org.example.leetcode;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * РЕШЕНИЕ:
 * два указателя, свапы
 */
public class LC344 {

    public static void main(String[] args) {
        String s = "hT6$O2Mk+fi^uzY,*|Ja#bRwlPQ%_}yv=8VnC1GpZXq3rj(t)d{5g&@N-[Eo\"7x/Us;`<e!>4AS[c9L_0BhK~F)D'g+iW";
        char[] str = s.toCharArray();
        reverse(str);
        System.out.println(str);
    }

    private static void reverse (char[] str) { // O(n), O(1)
        int left = 0, right = str.length - 1;
        char temp;
        while (left <= right) {
            temp = str[right];
            str[right] = str[left];
            str[left] = temp;
            left++;
            right--;
        }
    }

}


/*

Lorem k+fi^uzY,*|Ja ipsum `<e!>4AS[c9L_0BhK~F)D'g+iW dolor a#bRwlPQ%_}yv sit amet, 2Mk+fi^uzY,*|Ja#bRwlPQ%_}yv consectetur hT6$O2Mk+fi^uzY,*|Ja#bRwlPQ%_}yv=8VnC1GpZXq3rj(t)d{5g&@N-[Eo"7x/Us;`<e!>4AS[c9L_0BhK~F)D'g+iW adipiscing elit. Aliquam `<e!>4AS[c9L_0BhK~F)D'g+iW sagittis sapien sed turpis Wi+g'D)F~KhB0_L9c[SA4>!e<`;sU/x7"oE[-N@&g5{d)t(jr3qXZpG1CnV8=vy}_%QPlwRb#aJ|*,Yzu^if+kM2O$6Th fermentum, a -[Eo"7x/Us;`< auctor mauris hK~F)D'g+iW volutpat. Nunc q3rj(t)d{5g&@N viverra porta hK~F)D'g+iW sapien a#bRwlPQ%_}yv=8VnC1GpZXq3rj(t)d{5g&@N-[Eo"7x/Us; vel euismod. Pellentesque Wi+g'D)F~KhB0_L9c[SA4>!e<`;sU/x7"oE[-N@&g5{d)t(jr3qXZpG1CnV8=vy}_%QPlwRb#aJ|*,Yzu^if+kM2O$6Th habitant morbi tristique q3rj(t)d{5g&@N senectus et hK~F)D'g+iW netus et malesuada fames ac turpis egestas. Maecenas a#bRwlPQ%_}yv=8VnC1GpZXq3rj(t)d{5g&@N-[Eo"7x/Us; tristique !>4AS[c9L_0Bh metus quis nisi feugiat, id q3rj(t)d{5g&@N ullamcorper k+fi^uzY,*|Ja ipsum ultrices. Nullam vulputate a#bRwlPQ%_}yv=8VnC1GpZXq3rj(t)d{5g&@N-[Eo"7x/Us; ligula vel diam RwlPQ%_}yv=8VnC1GpZXq3rj(t)d{5g&@N-[Eo"7x/Us;`<e!>4AS[c9L_0 suscipit, a blandit sapien 2Mk+fi^uzY,*|Ja#bRwlPQ%_}yv cursus. Sed euismod Wi+g'D)F~KhB0_L9c[SA4>!e<`;sU/x7"oE[-N@&g5{d)t(jr3qXZpG1CnV8=vy}_%QPlwRb#aJ|*,Yzu^if+kM2O$6Th felis sit !>4AS[c9L_0Bh amet felis =8VnC1GpZXq3rj euismod, at sollicitudin turpis molestie. Vestibulum ut libero ultrices, laoreet libero -[Eo"7x/Us;`< eget, scelerisque augue. Phasellus RwlPQ%_}yv=8VnC1GpZXq3rj(t)d{5g&@N-[Eo"7x/Us;`<e!>4AS[c9L_0 at nulla vel a#bRwlPQ%_}yv est mollis -[Eo"7x/Us;`< bibendum. Fusce nec hT6$O2Mk+fi^uzY,*|Ja#bRwlPQ%_}yv=8VnC1GpZXq3rj(t)d{5g&@N-[Eo"7x/Us;`<e!>4AS[c9L_0BhK~F)D'g+iW velit velit. Nunc a#bRwlPQ%_}yv pharetra consequat Wi+g'D)F~KhB0_L9c[SA4>!e<`;sU/x7"oE[-N@&g5{d)t(jr3qXZpG1CnV8=vy}_%QPlwRb#aJ|*,Yzu^if+kM2O$6Th justo quis pretium. Nulla facilisi. Nam vel sapien in massa euismod ullamcorper =8VnC1GpZXq3rj non non ipsum. Sed aliquet 2Mk+fi^uzY,*|Ja#bRwlPQ%_}yv enim ut nunc hK~F)D'g+iW viverra RwlPQ%_}yv=8VnC1GpZXq3rj(t)d{5g&@N-[Eo"7x/Us;`<e!>4AS[c9L_0 bibendum. Sed euismod !>4AS[c9L_0Bh est quis hT6$O2Mk+fi^uzY,*|Ja#bRwlPQ%_}yv=8V leo vehicula consequat. Sed tristique, hT6$O2Mk+fi^uzY,*|Ja#bRwlPQ%_}yv=8V velit sit amet k+fi^uzY,*|Ja pellentesque `<e!>4AS[c9L_0BhK~F)D'g+iW malesuada, erat =8VnC1GpZXq3rj magna vestibulum lacus, nec malesuada lorem sapien ut neque. */