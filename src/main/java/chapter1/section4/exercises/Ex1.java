package chapter1.section4.exercises;

/**
 * 证明：当N=3时，N(N-1)(N-2)/6 = 1, 式子成立。
 * 假设当N=k-1时成立，
 * 当N = k时，3个数字的组合分成两种情况：
 * a. 包括新加的数字
 * b. 不包括新加的数字
 * b的情况有 (k-1)(k-2)(k-3)/6
 * a的情况有(k-1)(k-2)/2
 * 加起来为 (3+k-3)(k-1)(k-2)/6 = k(k-1)(k-2)/6，符合命题
 * 得证
 */
public class Ex1 {
}