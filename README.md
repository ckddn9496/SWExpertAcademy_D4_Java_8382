# SWExpertAcademy_D4_Java_8382

## SW Expert Academy D4 8382. 방향 전환

### 1. 문제설명

출처: https://swexpertacademy.com/main/code/problem/problemList.do

input으로 공백으로 나눠진 `x1`, `y1`, `x2`, `y2`가 들어온다. `(x1, y1)`에서 `(x2, y2)`로 이동을 하려고한다. 점은 좌우상하로 움직일 수 있으며 가로 방향으로 움직였다면 다음 번은 세로방향으로만 움직일 수 있는 규칙이 있다고 할때, 최소 몇 번의 이동을 해야 이동할 수 있을지 구하는 문제.

[입력]
> 첫 번째 줄에 테스트 케이스의 수 `T`가 주어진다.
> 각 테스트 케이스의 첫 번째 줄에는 네 정수 `x1`, `y1`, `x2`, `y2` `(-100 ≤ x1, y1, x2, y2 ≤ 100)`이 공백 하나로 구분되어 주어진다.


[출력]
> 각 테스트 케이스마다 `#x`(`x`는 테스트케이스 번호를 의미하며 `1`부터 시작한다)를 출력하고,
> 각 테스트 케이스마다 최소 몇 번의 이동을 해야 하는지 출력한다.

### 2. 풀이

`x1`과 `x2`의 차이이인 `dx`와, `y1`과 `y2`의 차이인 `dy`를 구하였다. 가로와 세로를 번갈아서 이동해야만 하므로 `min(dx,dy)`만큼 대각선으로 이동하게되며 이때의 이동 횟수는 `2 * min(dx,dy)`이다. 이때 `dx`와 `dy`의 차이를 `diff`라고 하자. `diff`만큼 가로로 혹은 세로로 이동하게 되면 원하는 점 `(x2, y2)`에 이동할 수 있다. 이때 `diff`의 값에 따라 이동 횟수가 다르다. `diff`가 1, 2, 3, 4, 5, ...의 거리를 가지면 도착하기 위한 이동거리는 1, 4, 5, 8, 9, ...의 규칙을 가진다. 짝수와 홀수에 따라 다른 순열을 가지고 있음을 알게되고 이를 일반식으로 만들어 계산하여 필요한 이동거리를 계산하였다.

```java

String[] points = sc.nextLine().split(" ");
			
int dx = Math.abs(Integer.parseInt(points[0]) - Integer.parseInt(points[2]));
int dy = Math.abs(Integer.parseInt(points[1]) - Integer.parseInt(points[3]));

int min = 0;
int diff = 0;
if (dx > dy) {
  min = dy;
  diff = dx - dy;
} else {
  min = dx;
  diff = dy - dx;				
}
int step = min*2;
if (diff % 2 == 0) {
  step += 2*diff;
} else {
  step += 2*diff - 1;
}

System.out.println("#"+test_case+" "+step);

```
