import sys

filepath = r"c:\Users\User\IdeaProjects\mobileauto\src\main\java\org\example\Loyalty.java"

with open(filepath, "r", encoding="utf-8") as f:
    lines = f.readlines()

out_lines = []
for i, line in enumerate(lines):
    stripped = line.strip()
    if stripped.startswith("System.out.println") and any(k in stripped for k in ["Клик", "Ввод", "Проверка"]):
        has_sleep = False
        j = i - 1
        while j >= 0:
            s_j = lines[j].strip()
            if not s_j:
                j -= 1
                continue
            if s_j.startswith("//"):
                j -= 1
                continue
            if s_j.startswith("System.out.println"):
                # Ignore other prints just above it (like "✅ ...") when searching for sleeps
                j -= 1
                continue
            if "Thread.sleep" in s_j:
                has_sleep = True
            break
        
        if not has_sleep:
            indent = line[:len(line) - len(line.lstrip())]
            out_lines.append(f"{indent}Thread.sleep(1000);\n")
            
    out_lines.append(line)

with open(filepath, "w", encoding="utf-8") as f:
    f.writelines(out_lines)

print("Modification complete.")
