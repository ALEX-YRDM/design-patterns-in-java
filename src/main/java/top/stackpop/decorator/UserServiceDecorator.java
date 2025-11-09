package top.stackpop.decorator;

public abstract class UserServiceDecorator implements UserService{

    protected final UserService delegate;

    protected UserServiceDecorator(UserService delegate){
        this.delegate = delegate;
    }

    @Override
    public User getUserById(int id) {
        return delegate.getUserById(id);
    }

    
    
}
