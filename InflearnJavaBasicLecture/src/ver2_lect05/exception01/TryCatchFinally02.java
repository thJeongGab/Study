package ver2_lect05.exception01;

public class TryCatchFinally02 {

    public static void main(String[] args) {

        try {

            System.out.println("try-catch-finally 구문이 실행되었습니다.");

            int allSum = 10 / 0;

        } catch (Exception e) {

            System.out.println("예외가 발생하였습니다.");

        } finally {
            System.out.println("try-catch-finally 구문이 종료되었습니다.");
        }

        /**
         * 위의 코드는 try-catch-finally 구문을 실행시켜 본 것입니다.
         * 본래는 업무 로직이 들어가야 하지만, 각 위치마다 콘솔에 글자를 찍는 메소드를 위치시켜
         * 실질적으로 어떻게 동작하나 확인해 본 것입니다.
         * 이를 통해 try-catch-finally가 어떻게 동작하는지 확인할 수 있습니다.
         *
         * 10 / 0의 로직의 경우 0으로 나누려 하기 때문에
         * 예외가 발생합니다.
         * 본래 나누기에서 0은 나눌 수 없는 것입니다.
         * 그렇기 때문에 컴퓨터는 예외를 확인하고 넘겨주는 것이지요.
         * 그리고 finally 구문은 예외를 확인하고 마지막에 반드시 동작하는 것입니다.
         *
         * 밑에 catch 없이 동작시키는 것도 해보겠습니다.
         */

        try {
            System.out.println("업무 로직입니다.");
        } catch (Exception e) {
            System.out.println("예외가 발생하였네요.");
        } finally {
            System.out.println("마지막 위치입니다.");
        }

        /**
         * 위의 구문에서는 예외가 발생하였네요를 타지 않았습니다.
         * 해당 구문은 타지 않은 이유가 예외가 발생하지 않았기 때문이죠.
         * 그렇기 때문에 업무 로직입니다와 마지막 위치입니다만 콘솔에 찍힌 것입니다.
         *
         * 보통 finally 구문은 마지막에 무언가 처리를 꼭 해줘야 할 때 씁니다.
         * 대표적으로 데이터베이스 커넥션을 할 때 사용합니다.
         * 데이터베이스는 커넥션을 맺고 데이터베이스에서
         * 조회, 저장, 수정, 삭제 작업을 하고 난 뒤 데이터베이스의 커넥션을 닫습니다.
         * 이때 작업에 예외가 발생할 수 있으므로
         * 데이터베이스 작업은 try 구문에서 실행하고
         * finally 구문에서 데이터베이스의 커넥션을 닫는 작업을 수행합니다.
         * 또는 쓰레드를 사용할 때도 쓸 때가 있지요.
         *
         * 각각의 경우의 수가 있습니다.
         *
         * 이것은 입문 과정에서 너무 깊이 알려고 서두르지 않으셔도 됩니다.
         * 입문을 잘 마치시고, 기본 또는 기초 과정으로 올라서면서 이론을 좀 더 익히시고,
         * 그 다음에 많은 연습을 해보시면서 사용법을 익히시면 됩니다.
         *
         * 후에 실무에 가서 많은 코드를 짜보면서 몸에 숙련되는 길까지
         * 나아가실 수 있으시게 됩니다.
         *
         * 감사합니다.
         *
         * 다음 실습 강의에서는 throw를 해볼 예정입니다.
         */

    }

}
