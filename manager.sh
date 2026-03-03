
git status
git branch

FECHA=$(date +"%Y-%m-%d_%H-%M-%S")
HASH="$(git log -1 --pretty=%H)" 

if [ -d "status" ]; then
	echo "status existe"
else 
	echo "creando status"
	mkdir status
fi

echo "status existe"
echo "$HASH" >> ./status/registro.txt
echo "$FECHA" >> ./status/registro.txt
echo "-------------" >> ./status/registro.txt
git status >> ./status/registro.txt
git branch >> ./status/registro.txt
echo "-------------" >> ./status/registro.txt
