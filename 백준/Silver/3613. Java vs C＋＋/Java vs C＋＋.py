import sys, re

def is_java(string):
    if re.fullmatch('[a-z][a-zA-Z]*', string) is None:
        return False
    return True

def is_cpp(string):
    if re.fullmatch('[a-z][a-z_]*', string) is None:
        return False
    if '' in re.split('_', string):
        return False
    return True

def change_to_cpp(string):
    return re.sub('[A-Z]', '_\g<0>', string).lower()

def change_to_java(string):
    pieces = re.split('_', string)
    result = pieces[0]
    for idx in range(1, len(pieces)):
        result += pieces[idx][0].upper()
        if len(pieces[idx]) > 1:
            result += pieces[idx][1:]
    return result

variable = sys.stdin.readline().rstrip()
if is_java(variable):
    print(change_to_cpp(variable))
elif is_cpp(variable):
    print(change_to_java(variable))
else:
    print("Error!")