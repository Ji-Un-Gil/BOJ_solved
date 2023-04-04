import re


def solution(word, pages):
    content_pattern = re.compile(r'<meta\sproperty="og:url"\scontent="https:\/\/\S+"')
    duplicate_pattern = re.compile(r'(?i)'+word+r'[^a-zA-Z]')
    word_pattern = re.compile(r'[^a-zA-Z](?i)'+word+r'[^a-zA-Z]'
                              + r'|[^a-zA-Z](?i)'+word+r'$'
                              + r'|^(?i)'+word+'[^a-zA-Z]'
                              + r'|^(?i)'+word+'$')
    href_pattern = re.compile(r'<a\shref="https:\/\/(?:.*?)">')
    link_pattern = re.compile(r'<a\shref="|">')
    board = {}
    for idx in range(len(pages)):
        token = re.search(content_pattern, pages[idx])
        start, end = token.start(), token.end()
        token = pages[idx][start:end].split('=')[-1][1:-1]
        # 주소명
        if token not in board.keys():
            board[token] = [-1, 0, 0, 0]
        if board[token][0] == -1:
            board[token][0] = idx
        # 기본 점수
        new_word = re.sub(duplicate_pattern, word+'00', pages[idx])
        board[token][1] += len(re.findall(word_pattern, new_word))
        # 외부 링크 수
        external_link = re.findall(href_pattern, pages[idx])
        board[token][2] += len(external_link)
        # 링크 점수
        for link_token in external_link:
            link = re.split(link_pattern, link_token)[1]
            if link not in board.keys():
                board[link] = [-1, 0, 0, 0]
            board[link][3] += board[token][1] / board[token][2]

    to_del = []
    for page in board.keys():
        if board[page][0] == -1:
            to_del.append(page)
    for page in to_del:
        del board[page]
    answer = sorted(board.items(), key=lambda item: (-(item[1][1]+item[1][3]), item[1][0]))[0][1][0]
    return answer