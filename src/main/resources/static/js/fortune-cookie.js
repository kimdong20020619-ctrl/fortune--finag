let cookieOpened = false;

function openCookie() {
    if (cookieOpened) return; // 이미 열렸으면 막기

    // 하루 1번 제한
    const today = new Date().toISOString().slice(0, 10);
    const savedDay = localStorage.getItem("cookieDate");

    if (savedDay === today) {
        document.getElementById("cookieMessage").innerText =
            localStorage.getItem("cookieMessage");
        return;
    }

    cookieOpened = true;

    const full = document.getElementById("cookieFull");
    const left = document.getElementById("cookieLeft");
    const right = document.getElementById("cookieRight");
    const messageBox = document.getElementById("cookieMessage");

    // 전체 쿠키 숨기기
    full.style.opacity = 0;

    // 조각 보여주기 + 애니메이션
    setTimeout(() => {
        left.classList.add("open");
        right.classList.add("open");
    }, 200);

    // 메시지 목록
    const messages = [
        "오늘 당신에게 작은 기회가 찾아옵니다.",
        "무심코 한 행동이 큰 행운을 부릅니다.",
        "당신을 돕는 사람이 곁에 있습니다.",
        "좋은 소식이 곧 다가옵니다.",
        "당신이 원하는 방향으로 일이 풀립니다.",
        "작은 선택이 큰 변화를 만듭니다.",
        "당신의 진심이 전달되는 날입니다.",
        "컨디션이 좋아지고 기분이 상승합니다.",
        "뜻밖의 행운이 찾아올 수 있어요!",
        "오늘은 자신에게 조금 더 여유를 주세요."
    ];

    const randomMessage = messages[Math.floor(Math.random() * messages.length)];

    // 메시지 출력 (애니메이션 끝난 뒤)
    setTimeout(() => {
        messageBox.innerText = randomMessage;

        // 하루 1회 저장
        localStorage.setItem("cookieDate", today);
        localStorage.setItem("cookieMessage", randomMessage);

    }, 1000);
}
