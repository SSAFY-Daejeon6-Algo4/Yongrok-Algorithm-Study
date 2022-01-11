function solution(w, h) {
  let a = w;
  let b = h;

  while (a > 0) {
    const r = b % a;
    b = a;
    a = r;
  }

  return w * h - w - h + b;
}
